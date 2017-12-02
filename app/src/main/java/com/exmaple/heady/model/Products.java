package com.exmaple.heady.model;

import com.exmaple.heady.utility.Constant;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static com.exmaple.heady.utility.Constant.DateFormat.INPUT_FORMAT;

public class Products extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    @SerializedName(Constant.Params.DATE_ADDED)
    private String dateAdded;
    private Tax tax;
    private RealmList<Variants> variants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public RealmList<Variants> getVariants() {
        return variants;
    }

    public String getFormattedDate(String outputFormat) {
        try {
            final SimpleDateFormat inFormat = new SimpleDateFormat(INPUT_FORMAT);
            final SimpleDateFormat outFormat = new SimpleDateFormat(outputFormat);

            return outFormat.format(inFormat.parse(dateAdded));
        } catch (ParseException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            return dateAdded;
        }
    }
}
