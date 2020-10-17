package org.dnd3.udongsa.neighborcats.feed.entity;

import org.dnd3.udongsa.neighborcats.feed.dto.FeedDto;
import org.dnd3.udongsa.neighborcats.imgfile.dto.ImgFileDto;
import org.dnd3.udongsa.neighborcats.servant.entity.Servant;
import org.dnd3.udongsa.neighborcats.servant.entity.ServantTestBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FeedTestBuilder {

  public static Feed build(String content){
    Servant author = ServantTestBuilder.build("집사1");
    return Feed.of(content, author);
  }

  public static List<Feed> buildFeeds(String content){
    List<Feed> feeds = new ArrayList<>();
    for(int i=1; i<4; i++){
      feeds.add(FeedTestBuilder.build(""+i));
    }
    return feeds;
  }

  public static List<FeedDto> buildFeedDtoList(String content){
    List<FeedDto> dtoList = new ArrayList<>();
    for(int i=1; i<2; i++){
      FeedDto feedDto = new FeedDto();
      feedDto.setId(Long.valueOf(i));
      feedDto.setContent(content + i);
      List<ImgFileDto> images = new ArrayList<>();
      images.add(new ImgFileDto(0L, "http://woodongjip.com/api/imgfiles/1"));
      feedDto.setImages(images);
      feedDto.setCreatedDateTime(LocalDateTime.now().toString());
      dtoList.add(feedDto);
    }
    return dtoList;
  }
}
