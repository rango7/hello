package com.evergrande.sonar.checks;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

import java.io.StringReader;

public class saas {
    public static void main(String[] args) {
        Analyzer analyzerStanderd = new StandardAnalyzer(Version.LUCENE_35);
        TokenStream tokensStream = analyzerStanderd.tokenStream("content",new StringReader("StandardAnalyzer"));
        System.out.println(123);


    }
}
