package com.bee.beeonline.jpush;

import android.os.Parcel;
import android.os.Parcelable;

public class Extra implements Parcelable {
    public int type;
    public String value;

    public Extra() {
    }

    public Extra(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int valueInt() {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean canUse() {
        return type > 0;
    }

    public static final Creator<Extra> CREATOR = new Creator<Extra>() {
        @Override
        public Extra createFromParcel(Parcel in) {
            return new Extra(in);
        }

        @Override
        public Extra[] newArray(int size) {
            return new Extra[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    protected Extra(Parcel in) {
        type = in.readInt();
        value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(value);
    }
}
