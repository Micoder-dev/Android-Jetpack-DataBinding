package com.example.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class PersonModel3 extends BaseObservable {

    String name;

    public PersonModel3(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
