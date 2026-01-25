import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int n = genres.length;
        List<Album> albums = new ArrayList<>();
        Map<String, Integer> albumIndex = new HashMap<>();
        
        int index = 0;
        for(int i = 0; i < n; i++){
            
            String genre = genres[i];
            
            //  0 < 1
            if(!albumIndex.containsKey(genre)){
                albumIndex.put(genre, albums.size());
                albums.add(new Album(genre, 0));
            }
            
            int cur = albumIndex.get(genre);
            albums.get(cur).addPlayCount(plays[i]);
            
            // play 관리
            Album currentAlbum = albums.get(cur);
            currentAlbum.pq.add(new Play(i, plays[i]));
            
        }
        
        albums.sort(null);
        
       List<Integer> result = new ArrayList<>();

        for (Album album : albums) {
            int count = 0;
            // 장르 내에서 최대 2개까지만 추출
            while (!album.pq.isEmpty() && count < 2) {
                result.add(album.pq.poll().index);
                count++;
            }
        }

// List<Integer>를 int[]로 변환
return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Album implements Comparable<Album> {
        String genre;
        int playCount;
        Queue<Play> pq;
        
        Album(String genre, int playCount){
            this.genre = genre;
            this.playCount = playCount;
            this.pq = new PriorityQueue<>();
        }
        
        void addPlayCount(int playCount){
            this.playCount += playCount;
        }
        
        @Override
        public int compareTo(Album o){
            return Integer.compare(this.playCount, o.playCount) * -1;
        }
        
        
    }
    
    static class Play implements Comparable<Play>{
        int index;
        int play;
        
        Play(int index, int play){
            this.index = index;
            this.play = play;
        }
        
        public int compareTo(Play o){
            if(play == o.play){
                return Integer.compare(index, o.index) ;
            }
            
            return Integer.compare(play, o.play) * -1;
        }
    }
}

// 두 장르를 먼저 뽑는게 우선
// 장르 중 뭘 내보낼지 