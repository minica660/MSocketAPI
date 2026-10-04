package com.minicash;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public interface MSocketAPI {

    /**
     * 通知受取用のリスナーを登録する
     */
    void addListener(MSocketListener listener);

    /**
     * 登録していたリスナーを解除する
     */
    void removeListener(MSocketListener listener);

    /**
     * サーバーからの返り値（レスポンス）を非同期で待つ送信メソッド
     */
    CompletableFuture<Map<String, Object>> sendRequestAsync(String action, Map<String, Object> data);

    /**
     * サーバーへデータを「送りっぱなし」にするための超軽量送信メソッド
     */
    CompletableFuture<Void> sendAndForgetAsync(String action, Map<String, Object> data);

    /**
     * サーバーとの接続状態を確認するメソッド
     */
    CompletableFuture<Boolean> isServerAlive();





}
