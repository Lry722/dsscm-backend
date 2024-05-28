package cn.dsscm.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

// 图片服务接口
// 应当支持多种实现，如本地文件系统、OSS云服务等
public interface ImageService {
    public String upload(String part, MultipartFile file) throws IllegalStateException, IOException;
    public void delete(String part, String filename);
    public byte[] get(String part, String fileName) throws IOException;
}
