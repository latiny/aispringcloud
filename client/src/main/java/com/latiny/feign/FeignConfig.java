package com.latiny.feign;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import feign.Request.Options;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FeignConfig {

    private int connectTimeoutMillis = 5000;
    private int readTimeoutMillis = 25000;
    
	private ObjectFactory<HttpMessageConverters> messageConverters = new ObjectFactory<HttpMessageConverters>() {
		@Override
		public HttpMessageConverters getObject() {
			HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new FastJsonHttpMessageConverter());
			return httpMessageConverters;
		}
	};

	@Bean
	public Decoder feignDecoder() {
		return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
	}

	@Bean
	public Encoder feignEncoder() {
		return new SpringEncoder(this.messageConverters);
	}

	@Bean
	public Options options() {
		return new Options(connectTimeoutMillis, readTimeoutMillis);
	}

//	@Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        //创建FastJson信息转换对象
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter =
//                new FastJsonHttpMessageConverter();
//
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        //从1.1.41升级到1.2.之后的版本必须配置，否则会报错
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
//
//        //创建FastJson对象并设定序列化规则
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        //添加自定义valueFilter
//        //规则赋予转换对象
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        StringHttpMessageConverter stringHttpMessageConverter =
//                new StringHttpMessageConverter(Charset.defaultCharset());
//
//        fastJsonConfig.setSerializerFeatures(
//                //消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
//                SerializerFeature.DisableCircularReferenceDetect,
//                //是否输出值为null的字段,默认为false
//                SerializerFeature.WriteMapNullValue
//        );
//
//        return new HttpMessageConverters(fastJsonHttpMessageConverter, stringHttpMessageConverter);
//    }
}
