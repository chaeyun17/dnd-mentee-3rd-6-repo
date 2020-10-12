package org.dnd3.udongsa.neighborcats.doc.feed;

import static org.dnd3.udongsa.neighborcats.doc.ApiDocUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dnd3.udongsa.neighborcats.doc.APIDocTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.ResultActions;

public class FeedDoc extends APIDocTest{
  
  @Test
  public void getSummaryFeeds() throws Exception{
    // Given
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer abc123token");

    // when
    ResultActions action = mockMvc.perform(get("/api/feeds/me/album")
      .headers(httpHeaders));

    // then
    action
      .andExpect(status().isOk())
      .andDo(document(documentName
        , getDocumentResponse()
        , responseFields(FeedFieldDesc.getFeedsAlbumResponse())));
    

  }
}
