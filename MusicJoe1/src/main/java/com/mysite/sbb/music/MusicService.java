package com.mysite.sbb.music;

import com.mysite.sbb.music.dto.MusicListDto;
import com.mysite.sbb.music.dto.MusicRepository;
import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicRepository musicRepository;

    public List<MusicListDto> getList() {
        // DB에서 음악을 가져와서 화면용 데이터(Dto)로 변환합니다.
        List<Music> musicList = this.musicRepository.findAllByOrderByCreateDateDesc();
        return musicList.stream()
                .map(music -> new MusicListDto(
                    music.getId(), 
                    music.getTitle(), 
                    music.getArtist(), 
                    music.getThumbnailUrl(), 
                    music.getCreateDate()))
                .collect(Collectors.toList());
    }

    // ★ 컨트롤러와 약속한 대로 인자를 정확히 5개만 받습니다.
    public void create(String title, String artist, String url, String content, SiteUser author) {
        Music m = new Music();
        m.setTitle(title);
        m.setArtist(artist);
        m.setUrl(url);
        m.setContent(content);
        m.setAuthor(author);
        m.setCreateDate(LocalDateTime.now());
        
        if (url != null && url.contains("v=")) {
            String videoId = url.split("v=")[1].split("&")[0];
            m.setThumbnailUrl("https://img.youtube.com/vi/" + videoId + "/mqdefault.jpg");
        }
        
        this.musicRepository.save(m);
    }

    public Music getMusic(Integer id) {
        return this.musicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Music not found"));
    }
}