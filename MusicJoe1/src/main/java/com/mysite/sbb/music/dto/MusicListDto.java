package com.mysite.sbb.music.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MusicListDto {
    private Integer id;
    private String title;
    private String artist;
    private String thumbnailUrl;
    private LocalDateTime createDate;

    // MusicService에서 사용하기 위해 이 생성자가 반드시 필요합니다!
    public MusicListDto(Integer id, String title, String artist, String thumbnailUrl, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.thumbnailUrl = thumbnailUrl;
        this.createDate = createDate;
    }
}