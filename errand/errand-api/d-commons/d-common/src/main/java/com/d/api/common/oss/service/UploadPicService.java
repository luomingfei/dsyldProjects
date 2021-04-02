package com.d.api.common.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.d.api.common.constants.FileConstants;
import com.d.api.common.exception.BusinessException;
import com.d.api.common.properties.AliyunProperties;
import com.d.api.common.utils.FileUtil;
import com.d.api.common.oss.result.UploadPicResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author dsscccc
 * @Description
 * @date 2020/12/13 20:21
 */
@Service
public class UploadPicService {

    private final OSS ossClient;
    private final AliyunProperties aliyunConfig;

    public UploadPicService(OSS ossClient, AliyunProperties aliyunConfig) {
        this.ossClient = ossClient;
        this.aliyunConfig = aliyunConfig;
    }

    public UploadPicResult uploadPic(MultipartFile multipartFile, Integer type, Integer sort) {
        if(multipartFile.isEmpty()){
            return null;
        }
        // 1. 对上传的图片进行校验: 这里简单校验后缀名
        // 另外可通过ImageIO读取图片的长宽来判断是否是图片,校验图片的大小等。
        // TODO 图片校验
        boolean isPic = false;
        for (String imageType : FileConstants.IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), imageType)) {
                isPic = true;
                break;  // 只要与允许上传格式其中一个匹配就可以
            }
        }
        if (!isPic) {
            throw new BusinessException("请上传正确图片格式");
        }
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = null;
        String filePath = FileUtil.getFilePath(FileConstants.HOUSE_MOULE_NAME,multipartFile.getOriginalFilename());
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpg");
            putObjectRequest = new PutObjectRequest(aliyunConfig.getOss().getBucketName(), filePath, new ByteArrayInputStream(multipartFile.getBytes()),metadata);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        UploadPicResult uploadPicResult = new UploadPicResult();
        uploadPicResult.setUrl(aliyunConfig.getOss().getUrlPrefix() + filePath);
        uploadPicResult.setType(type);
        uploadPicResult.setSort(sort==null?0:sort);
        // 关闭OSSClient。
        return uploadPicResult;
    }

}
