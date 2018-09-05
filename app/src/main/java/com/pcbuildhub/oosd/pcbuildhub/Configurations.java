package com.pcbuildhub.oosd.pcbuildhub;

import android.content.res.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//pojo class for configs
public class Configurations implements Serializable
{
    private int itemId;
    private String monitorName;
    private int monitorPrice;
    private String processorName;
    private int processorPrice;
    private String motherboardName;
    private int motherboardPrice;
    private String gpuName;
    private int gpuPrice;
    private String hddName;
    private int hddPrice;
    private String ramName;
    private int ramPrice;
    private int totalPrice;


    //An array list to add all the config in one array
    //there are two getter and setter method at the end of the page.......
    private static List<Configurations>configurations = new ArrayList<>();

    //constructor of the class
    public Configurations(int itemId, String monitorName, int monitorPrice, String processorName, int processorPrice, String motherboardName, int motherboardPrice, String gpuName, int gpuPrice, String hddName, int hddPrice, String ramName, int ramPrice, int totalPrice) {
        this.itemId = itemId;
        this.monitorName = monitorName;
        this.monitorPrice = monitorPrice;
        this.processorName = processorName;
        this.processorPrice = processorPrice;
        this.motherboardName = motherboardName;
        this.motherboardPrice = motherboardPrice;
        this.gpuName = gpuName;
        this.gpuPrice = gpuPrice;
        this.hddName = hddName;
        this.hddPrice = hddPrice;
        this.ramName = ramName;
        this.ramPrice = ramPrice;
        this.totalPrice = totalPrice;
    }


    //start of all the getter and setter of variables.....
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public int getMonitorPrice() {
        return monitorPrice;
    }

    public void setMonitorPrice(int monitorPrice) {
        this.monitorPrice = monitorPrice;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public int getProcessorPrice() {
        return processorPrice;
    }

    public void setProcessorPrice(int processorPrice) {
        this.processorPrice = processorPrice;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public int getMotherboardPrice() {
        return motherboardPrice;
    }

    public void setMotherboardPrice(int motherboardPrice) {
        this.motherboardPrice = motherboardPrice;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public int getGpuPrice() {
        return gpuPrice;
    }

    public void setGpuPrice(int gpuPrice) {
        this.gpuPrice = gpuPrice;
    }

    public String getHddName() {
        return hddName;
    }

    public void setHddName(String hddName) {
        this.hddName = hddName;
    }

    public int getHddPrice() {
        return hddPrice;
    }

    public void setHddPrice(int hddPrice) {
        this.hddPrice = hddPrice;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public int getRamPrice() {
        return ramPrice;
    }

    public void setRamPrice(int ramPrice) {
        this.ramPrice = ramPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    //end of all the getter and setter of variables.....


    //to add in the array list getter and setter methods....
    public static void addConfigsToList(Configurations config){
        configurations.add(config);
    }

    public static List<Configurations>getConfigList(){
        return configurations;
    }
}
