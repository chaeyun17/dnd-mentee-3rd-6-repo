package org.dnd3.udongsa.neighborcats.doc.feed;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;

import java.util.ArrayList;
import java.util.List;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.ParameterDescriptor;

public class FeedFieldDesc {

  public static List<FieldDescriptor> getAllResponse() {
    List<FieldDescriptor> fields = new ArrayList<>();
    fields.add(fieldWithPath("pageNumber").type(JsonFieldType.NUMBER).description("페이지 번호"));
    fields.add(fieldWithPath("pageSize").type(JsonFieldType.NUMBER).description("페이지 별 사이즈"));
    fields.add(fieldWithPath("totalPages").type(JsonFieldType.NUMBER).description("총 페이지 수"));
    fields.add(fieldWithPath("isLast").type(JsonFieldType.BOOLEAN).description("마지막 페이지 여부"));
    fields.add(fieldWithPath("isFirst").type(JsonFieldType.BOOLEAN).description("첫 페이지 여부"));
    fields.add(fieldWithPath("contents[]").type(JsonFieldType.ARRAY).description("피드 목록"));
    fields.add(fieldWithPath("contents[].id").type(JsonFieldType.NUMBER).description("피드 아이디"));
    fields.add(fieldWithPath("contents[].content").type(JsonFieldType.STRING).description("본문"));
    fields.add(fieldWithPath("contents[].author").type(JsonFieldType.OBJECT).description("작성자"));
    fields.add(fieldWithPath("contents[].author.id").type(JsonFieldType.NUMBER).description("작성자 식별자"));
    fields.add(fieldWithPath("contents[].author.nickName").type(JsonFieldType.STRING).description("작성자 이름"));
    fields.add(fieldWithPath("contents[].author.profileImg").type(JsonFieldType.STRING).description("작성자 프로필 이미지 URL"));
    fields.add(fieldWithPath("contents[].author.addressName").type(JsonFieldType.STRING).description("작성자 주소지"));
    fields.add(fieldWithPath("contents[].isLike").type(JsonFieldType.BOOLEAN).description("좋아요 여부"));
    fields.add(fieldWithPath("contents[].numberOfLikes").type(JsonFieldType.NUMBER).description("좋아요 갯수"));
    fields.add(fieldWithPath("contents[].numberOfComments").type(JsonFieldType.NUMBER).description("댓글 갯수"));
    fields.add(fieldWithPath("contents[].timeDesc").type(JsonFieldType.STRING).description("작성 후 경과시간"));
    fields.add(fieldWithPath("contents[].comments").type(JsonFieldType.ARRAY).description("댓글들(비어잇음)"));
    fields.add(fieldWithPath("contents[].images[]").type(JsonFieldType.ARRAY).description("피드 이미지"));
    fields.add(fieldWithPath("contents[].images[].id").type(JsonFieldType.NUMBER).description("이미지 식별자"));
    fields.add(fieldWithPath("contents[].images[].url").type(JsonFieldType.STRING).description("이미지 URL"));
    fields.add(fieldWithPath("contents[].createdDateTime").type(JsonFieldType.STRING)
        .description("작성일자. 예)2020-01-02T21:23:00"));
    return fields;
  }

  public static List<ParameterDescriptor> getAllByServantRequestParams() {
    List<ParameterDescriptor> fields = new ArrayList<>();
    fields.add(parameterWithName("number").description("페이지 번호"));
    fields.add(parameterWithName("size").description("페이지 별 사이즈"));
    fields.add(parameterWithName("sort").description("정렬. ex)createdAt,desc"));
    return fields;
  }

}
