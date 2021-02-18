package com.bjfu.newsrecommendation.service;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.List;

public class TensorflowService {
    private Graph graph = new Graph();
    private Session session = null;
    private String model_path = "";

    public void NERLstm(String model_path) {

        this.model_path = model_path;
        try {
            // 将pb文件转化为byte数组
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(this.model_path));
            // 将byte数组导入为tensorflow的计算图
            graph.importGraphDef(graphBytes);
            // 创建session
            session = new Session(graph);
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    public List<float[][]> Predict(Integer[] seq, int seq_len_list) {

        List<float[][]> result = new LinkedList<float[][]>();

        // 将数据放入Buffer
        Long[] data = new Long[seq_len_list];
        IntBuffer buffer = IntBuffer.allocate(seq_len_list);
        for (Integer integer : seq) {
            buffer.put(integer);
        }

        buffer.flip();
        // 利用Buffer创建Tensor变量
        long[] shape = {1, seq_len_list}; //Tensor变量的shape
        Tensor<Integer> word_ids = Tensor.create(shape, buffer);
        long[] shape_seq = {1};
        IntBuffer buffer_seq = IntBuffer.allocate(1);
        buffer_seq.put(seq_len_list);
        buffer_seq.flip();
        Tensor<Integer> sequence_lengths = Tensor.create(shape_seq, buffer_seq);
        Tensor<Float> drop_out = (Tensor<Float>) Tensor.create(1.0f);

        try {
            // 根据实际情况，feed需要的placeholder变量，fetch输出变量
            List<Tensor<?>> res = session.runner().feed("word_ids", word_ids).feed("sequence_lengths", sequence_lengths)
                    .feed("dropout", drop_out).fetch("logits_output").fetch("transitions").run();
            // 将Tensor变量转化为数组
            float[][][] logits = res.get(0).copyTo(
                    new float[(int) res.get(0).shape()[0]][(int) res.get(0).shape()[1]][(int) res.get(0).shape()[2]]);
            float[][] logits2D = logits[0];

            float[][] transparams = res.get(1)
                    .copyTo(new float[(int) res.get(1).shape()[0]][(int) res.get(1).shape()[1]]);
            result.add(logits2D);
            result.add(transparams);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}

