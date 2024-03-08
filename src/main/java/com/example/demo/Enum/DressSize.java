package com.example.demo.Enum;

public enum DressSize {
    S,M,L;
    public static DressSize convertToEnum(int size){
        DressSize dressSize = null;
        if(size > 0 & size <= 30){
            dressSize = DressSize.S;
        }
        else if(size > 30 & size <= 49){
            dressSize = DressSize.M;
        }
        else if(size >= 50){
            dressSize = DressSize.L;
        }
        return dressSize;
    }

}
