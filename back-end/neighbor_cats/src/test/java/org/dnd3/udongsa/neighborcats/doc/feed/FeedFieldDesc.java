package org.dnd3.udongsa.neighborcats.doc.feed;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import java.util.ArrayList;
import java.util.List;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;

public class FeedFieldDesc {

  public static List<FieldDescriptor> getFeedsAlbumResponse(){
    List<FieldDescriptor> fields = new ArrayList<>();
    fields.add(fieldWithPath("pageNumber").type(JsonFieldType.NUMBER).description("페이지 번호"));
    fields.add(fieldWithPath("pageSize").type(JsonFieldType.NUMBER).description("페이지 별 사이즈"));
    fields.add(fieldWithPath("totalPages").type(JsonFieldType.NUMBER).description("총 페이지 수"));
    fields.add(fieldWithPath("isLast").type(JsonFieldType.BOOLEAN).description("마지막 페이지 여부"));
    fields.add(fieldWithPath("contents[]").type(JsonFieldType.ARRAY).description("피드 목록"));
    fields.add(fieldWithPath("contents[].id").type(JsonFieldType.NUMBER).description("피드 아이디"));
    fields.add(fieldWithPath("contents[].images").type(JsonFieldType.STRING).description("피드 이미지"));
    fields.add(fieldWithPath("contents[].createdDateTime").type(JsonFieldType.STRING).description("작성일자. 예)2020-01-02T21:23:00"));
    return fields;
  }
  
}
