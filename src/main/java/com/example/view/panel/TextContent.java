package com.example.view.panel;

import java.util.ArrayList;
import java.util.List;

public interface TextContent {
    List<String> textContent = new ArrayList<>();

    default void setContent(List<String> content){
        textContent.addAll(content);
    }

    default List<String> getContent(){
        return textContent;
    }
}
