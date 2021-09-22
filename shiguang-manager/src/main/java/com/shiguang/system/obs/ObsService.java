package com.shiguang.system.obs;


import com.obs.services.LogConfigurator;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.CompleteMultipartUploadResult;
import com.obs.services.model.UploadFileRequest;



import java.io.File;

/**
 * 华为云OBS上传服务
 */
public class ObsService {
    private static final String TAG = "ObsService";
    //    private static Context mContext;
    ObsClient obsClient;


    public void initOSSClient() {
        LogConfigurator.enableLog();
        //配置
//        ObsConfiguration config = new ObsConfiguration();
//        config.setSocketTimeout(30000);
//        config.setConnectionTimeout(10000);
//        config.setEndPoint(OBSContance.INSTANCE.getEndPoint());
        // 创建ObsClient实例
        obsClient = new ObsClient("AHTXMQV0QBGQZH6SPK7H", "mwF0OH51ojCEPuthmGz3B15sSeLj7eoAhliPbboS", "obs.cn-north-4.myhuaweicloud.com");
    }

    public void upLoadToOBS(final String objectName, final String path) {

//        final String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/teas/data/";
        final File file = new File(path);
        if (file == null) {
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                //初始化OSSClient
                initOSSClient();
                //开始上传，参数分别为content，上传的文件名filename，上传的文件路径filePath

            }
        }).start();

    }


    public String beginUpload(String objectName, File file) {
        //通过填写文件名形成objectname,通过这个名字指定上传和下载的文件
        UploadFileRequest request = new UploadFileRequest("dm-em03", "xl-img/"+objectName);
// 设置待上传的本地文件，其中localfile为待上传的本地文件路径，需要指定到具体的文件名
        request.setUploadFile(file.getAbsolutePath());
// 设置分段上传时的最大并发数
        request.setTaskNum(5);
// 设置分段大小为10MB
        request.setPartSize(10 * 1024 * 1024);
// 开启断点续传模式
        request.setEnableCheckpoint(true);

        initOSSClient();
        try {
            // 进行断点续传上传
            CompleteMultipartUploadResult result = obsClient.uploadFile(request);
            String url = result.getObjectUrl();
            file.delete();
            return url;
        } catch (ObsException e) {
            // 发生异常时可再次调用断点续传上传接口进行重新上传
        }
        file.delete();
        return "";
    }

    static boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }
        return file.delete();
    }


}

