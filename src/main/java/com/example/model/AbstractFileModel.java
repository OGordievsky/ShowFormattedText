package com.example.model;

import java.nio.file.Path;

public abstract class AbstractFileModel implements GetFileData {
    protected Path fileUrl;

    public AbstractFileModel(Path fileUrl) {
        this.fileUrl = fileUrl;
    }
}