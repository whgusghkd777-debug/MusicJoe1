package com.mysite.sbb.music.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MusicListDto {
    private Integer id;
    private String title;
    private String artist;
    private String thumbnailUrl;
    private LocalDateTime createDate;

    // ★ 이 생성자가 있어야 Service에서 에러가 안 납니다!
    public MusicListDto(Integer id, String title, String artist, String thumbnailUrl, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.thumbnailUrl = thumbnailUrl;
        this.createDate = createDate;
    }
}