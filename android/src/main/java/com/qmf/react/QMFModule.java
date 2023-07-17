package com.qmf.react;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;

import androidx.annotation.Nullable;

import com.chinaums.pppay.unify.UnifyPayListener;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Files;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import com.unionpay.UPPayAssistEx;
import com.unionpay.UPSEInfoResp;

public class QMFModule extends ReactContextBaseJavaModule {
    private String appId;


    public QMFModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "QMF";
    }

    @ReactMethod
    public void UPPay(String tn, String serverMode) {
      UPPayAssistEx.startPay(getCurrentActivity(), null, null, tn, serverMode);
    }

//  @Override
//  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);
//    Log.d("ddebug","---onActivityResult---");
//    /**
//     * 处理银联云闪付手机支付控件返回的支付结果
//     */
//    if (data == null) {
//      return;
//    }
//
//    String msg = "";
//    /*
//     * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
//     */
//    String str = data.getExtras().getString("pay_result");
//    if (str.equalsIgnoreCase("success")) {
//      //如果想对结果数据校验确认，直接去商户后台查询交易结果，
//      //校验支付结果需要用到的参数有sign、data、mode(测试或生产)，sign和data可以在result_data获取到
//      /**
//       * result_data参数说明：
//       * sign —— 签名后做Base64的数据
//       * data —— 用于签名的原始数据
//       *      data中原始数据结构：
//       *      pay_result —— 支付结果success，fail，cancel
//       *      tn —— 订单号
//       */
//      msg = "云闪付支付成功";
//    } else if (str.equalsIgnoreCase("fail")) {
//      msg = "云闪付支付失败！";
//    } else if (str.equalsIgnoreCase("cancel")) {
//      msg = "用户取消了云闪付支付";
//    }
//    Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
//  }

}
