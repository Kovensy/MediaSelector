package com.example.media.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;

public class MediaSelectorFile implements Parcelable {
    public String fileName;
    public String filePath;
    public File file;
    public int fileSize;
    public int width;
    public int height;
    public String folderName;
    public String folderPath;
    public boolean isCheck;

    public MediaSelectorFile() {
    }

    protected MediaSelectorFile(Parcel in) {
        fileName = in.readString();
        filePath = in.readString();
        fileSize = in.readInt();
        width = in.readInt();
        height = in.readInt();
        folderName = in.readString();
        folderPath = in.readString();
        isCheck = in.readByte() != 0;
    }

    public static final Creator<MediaSelectorFile> CREATOR = new Creator<MediaSelectorFile>() {
        @Override
        public MediaSelectorFile createFromParcel(Parcel in) {
            return new MediaSelectorFile(in);
        }

        @Override
        public MediaSelectorFile[] newArray(int size) {
            return new MediaSelectorFile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fileName);
        dest.writeString(filePath);
        dest.writeInt(fileSize);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(folderName);
        dest.writeString(folderPath);
        dest.writeByte((byte) (isCheck ? 1 : 0));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MediaSelectorFile) {
            MediaSelectorFile mediaSelectorFile = (MediaSelectorFile) obj;
            if (mediaSelectorFile.filePath != null && this.filePath != null &&
                    mediaSelectorFile.filePath.equals(filePath)) {
                return true;
            }
        }
        return super.equals(obj);
    }
}