package com.example.rvesigame;

public class Score {
    private String players;
    private String playerwin;
    private String playerlose;
    private String score;

    public Score(String players,String playerwin,String playerlose,String score)
    {
        this.players=players;
        this.playerwin=playerwin;
        this.playerlose=playerlose;
        this.score=score;
    }
    public String getPlayers()
    {
        return players;
    }
    public String getPlayerwin()
    {
        return  playerwin;
    }
    public String getPlayerlose()
    {
        return  playerlose;
    }
    public String getScore()
    {
        return  score;
    }
    public void setPlayers(String players)
    {
        this.players=players;
    }
    public void setPlayerwin(String playerwin)
    {
        this.playerwin=playerwin;
    }
    public void SetPlayerlose(String playerlose)
    {
        this.playerlose=playerlose;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
