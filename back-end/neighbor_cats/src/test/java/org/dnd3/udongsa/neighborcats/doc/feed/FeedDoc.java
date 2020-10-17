package org.dnd3.udongsa.neighborcats.doc.feed;

import static org.dnd3.udongsa.neighborcats.doc.ApiDocUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.dnd3.udongsa.neighborcats.doc.APIDocTest;
import org.dnd3.udongsa.neighborcats.doc.ApiDocUtils;
import org.dnd3.udongsa.neighborcats.feed.dto.FeedDto;
import org.dnd3.udongsa.neighborcats.feed.dto.PagingDto;
import org.dnd3.udongsa.neighborcats.feed.entity.FeedTestBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class FeedDoc extends APIDocTest{
  
  @WithMockUser(roles = {"USER"})
  @Test
  public void getServantFeeds() throws Exception{
    // Given
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer abc123token");
    PagingDto<FeedDto> feedsWithPage = new PagingDto<>();
    List<FeedDto> feeds = FeedTestBuilder.buildFeedDtoList("hi");
    feedsWithPage.setContents(feeds);
    feedsWithPage.setFirst(true);
    feedsWithPage.setLast(false);
    feedsWithPage.setPageNumber(0);
    feedsWithPage.setPageSize(10);
    feedsWithPage.setTotalPages(10);
    given(feedService.findAllByServant(any(), any())).willReturn(feedsWithPage);
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("number", "0");
    params.add("size", "10");
    params.add("sort", "createdAt,desc");

    // when
    ResultActions action = mockMvc.perform(get("/api/servants/{servantId}/feeds", 1)
      .params(params)
      .headers(httpHeaders));

    // then
    action
      .andExpect(status().isOk())
      .andDo(document(documentName
                      , ApiDocUtils.getDocumentRequest()
                      , ApiDocUtils.getDocumentResponse()
                      , pathParameters(parameterWithName("servantId").description("집사 식별자"))
                      , requestParameters(FeedFieldDesc.getAllByServantRequestParams())
                      , responseFields(FeedFieldDesc.getAllResponse())
                      )
            );
    

  }
}
