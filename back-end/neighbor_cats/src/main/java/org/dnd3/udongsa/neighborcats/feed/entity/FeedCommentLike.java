package org.dnd3.udongsa.neighborcats.feed.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.dnd3.udongsa.neighborcats.servant.entity.Servant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Entity @Getter
public class FeedCommentLike {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn
  private FeedComment feedComment;

  @ManyToOne
  @JoinColumn
  private Servant servant;

  @CreationTimestamp
  private LocalDateTime createdDateTime;

  @UpdateTimestamp
  private LocalDateTime updatedDateTime;

  public static FeedCommentLike of(FeedComment feedComment, Servant servant){
    FeedCommentLike like = new FeedCommentLike();
    like.feedComment = feedComment;
    like.servant = servant;
    return like;
  }

}