package com.juaracoding.Utils;

public enum TestCases {

    // yg ada di Scenario di file .feature
    // nomor ini gak musti 1 s/d sekian yg penting urutan di Runner Test sdh benar
    T1("Login Valid Test"),
    T2("Login Invalid Test"),
    T3("Login Required Password Test"),
    T4("Login Required Username Test");

    private String testCasesName;

    //Constructor
    TestCases(String value){
        testCasesName = value;
    }

    // Getter & Setter
    public String getTestCasesName(){
        return testCasesName;
    }
}

/*
Note:
    Bagian ini nantinya harus disamakan dengan apa yang ada di .feature
    Misal, Jumlah test case di feature ada 100 maka skenario
    yg ada di file ini pun harus 100, bila tidak mau koding error semua
            --- RuntimeException: IndexOutOfBoundsException ----
*/