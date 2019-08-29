package com.th.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.th.exception.JsonException;

import java.io.IOException;
import java.util.List;

/**
 * Created by tianhui on 16/9/17.
 * Json工具
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String toJsonString(final T bean) {
        String jsonStrng = "";
        try {
            jsonStrng = objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new JsonException("json解析异常");
        }

        return jsonStrng;
    }

    public static <T> T jsonToBean(String json, Class<T> beanName) {
        T bean = null;
        try {
            bean  = objectMapper.readValue(json, beanName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonException("json解析异常");
        }

        return bean;
    }

    public static <T> List<T> jsonToList(String json, Class<T> beanName) {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, beanName);
            @SuppressWarnings("uncheck")
            List<T> list = objectMapper.readValue(json, collectionType);
            return list;
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new JsonException("json解析异常");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new JsonException("json映射串异常");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonException("json解析内部异常");
        }
    }
}
