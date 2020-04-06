package com.renata.mentesaudvel.Model;

public class Reading {

    public String reading_id;
    public String reading_image;
    public String reading_first_file;
    public String reading_second_file;
    public String reading_third_file;
    public String reading_name;

    public Reading() {

    }

    public Reading(String reading_id, String reading_image, String reading_first_file, String reading_second_file, String reading_third_file, String reading_name) {
        this.reading_id = reading_id;
        this.reading_image = reading_image;
        this.reading_first_file = reading_first_file;
        this.reading_second_file = reading_second_file;
        this.reading_third_file = reading_third_file;
        this.reading_name = reading_name;

    }

    public String getreading_id() {
        return  reading_id;
    }
    public void setreading_id(String reading_id) {
        this.reading_id = reading_id;
    }
    public String getreading_name() {
        return reading_name;
    }

    public void setreading_name(String reading_name) {
        this.reading_name = reading_name;
    }

    public String getreading_image() {
        return reading_image;
    }

    public void setreading_image(String reading_image) {
        this.reading_image = reading_image;
    }

    public String getreading_first_file() {
        return reading_first_file;
    }

    public void setreading_first_file(String reading_first_file) {
        this.reading_first_file = reading_first_file;
    }

    public String getreading_second_file() {
        return reading_second_file;
    }

    public void setreading_second_file(String reading_second_file) {
        this.reading_second_file = reading_second_file;
    }

    public String getreading_third_file() {
        return reading_third_file;
    }

    public void setreading_third_file(String reading_third_file) {
        this.reading_third_file = reading_third_file;
    }


}
