package com.lesson;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.google.common.base.Splitter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {


		EasyExcel.read(new File("D:\\tmp\\优惠券.xlsx")).sheet().autoTrim(Boolean.TRUE).registerReadListener(new AnalysisEventListener<HashMap<Integer,String>>(){

					@Override
					public void invoke(HashMap<Integer, String> integerStringHashMap, AnalysisContext analysisContext) {

						System.out.println(integerStringHashMap);

					}

					@Override
					public void doAfterAllAnalysed(AnalysisContext analysisContext) {

						System.out.println(analysisContext);

					}
				}).doRead();



//		Splitter splitter = Splitter.on("\n");
//		Splitter.MapSplitter keyValue = splitter.withKeyValueSeparator(":");
//		list
//				.stream()
//				.filter(o -> o instanceof HashMap)
//				.map(o -> (HashMap<Integer, String>) o)
//				.forEach(o -> {
//					checkValue(o.get(2),o.get(5),o.get(6),keyValue.split(o.get(8)));
//				});
	}

	private static void checkValue(String uid,String discount,String minAmount, Map<String,String> split) {
		if (!Objects.equals(uid,split.get("uid"))){
			throw new IllegalArgumentException();
		}

		if (!Objects.equals(discount,split.get("discount"))){
			throw new IllegalArgumentException();
		}

		if (!Objects.equals(minAmount,split.get("minAmount"))){
			throw new IllegalArgumentException();
		}

	}
}
