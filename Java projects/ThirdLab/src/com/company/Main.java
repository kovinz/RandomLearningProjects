package com.company;

public class Main {

    public static void main(String[] args) {
      IniFile ini = new IniFile("input.ini");
      Integer first = ini.getInteger("NCMD", "TidPacketVersionForTidControlCommand");
      String second = ini.getString("COMMON", "DiskCachePath");
      Double third = ini.getDouble("ADC_DEV", "SampleRate");
      System.out.println(first);
      System.out.println(second);
      System.out.println(third);

    }
}
