package com.qmf.react;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.unionpay.UPPayAssistEx;

public class QMFModule extends ReactContextBaseJavaModule {
    private String appId;

    private Context reactContent;


    public QMFModule(ReactApplicationContext context) {
        super(context);
        reactContent = context;
    }

    @Override
    public String getName() {
        return "QMF";
    }

    @ReactMethod
    public void UPPay(String tn, String serverMode) {
        UPPayAssistEx.startPay(getCurrentActivity(), null, null, tn, serverMode);
    }

    @ReactMethod
    public boolean checkWalletInstalled() {
        return UPPayAssistEx.checkWalletInstalled(reactContent);
    }

//  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);
    Log.d("ddebug","---onActivityResult---");
    /**
     * 处理银联云闪付手机支付控件返回的支付结果
     */
    if (data == null) {
      return;
    }

    String msg = "";
    /*
     * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
     */
    String str = data.getExtras().getString("pay_result");
    if (str.equalsIgnoreCase("success")) {
      //如果想对结果数据校验确认，直接去商户后台查询交易结果，
      //校验支付结果需要用到的参数有sign、data、mode(测试或生产)，sign和data可以在result_data获取到
      /**
       * result_data参数说明：
       * sign —— 签名后做Base64的数据
       * data —— 用于签名的原始数据
       *      data中原始数据结构：
       *      pay_result —— 支付结果success，fail，cancel
       *      tn —— 订单号
       */
      msg = "云闪付支付成功";
    } else if (str.equalsIgnoreCase("fail")) {
      msg = "云闪付支付失败！";
    } else if (str.equalsIgnoreCase("cancel")) {
      msg = "用户取消了云闪付支付";
    }
//    Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
  }

}
