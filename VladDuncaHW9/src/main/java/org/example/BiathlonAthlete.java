package org.example;

        import java.util.ArrayList;
        import java.util.List;

public class BiathlonAthlete implements Comparable<BiathlonAthlete> {
    private final int athleteNumber;
    private final String athleteName;
    private final String countryCode;
    private String skiTimeResult;
    private List<ShootingResult> firstShooting;
    private List<ShootingResult> secondShooting;
    private List<ShootingResult> thirdShooting;

    public BiathlonAthlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        firstShooting = new ArrayList<>();
        secondShooting = new ArrayList<>();
        thirdShooting = new ArrayList<>();
    }

    public int calculatePenaltyTime() {
        int penalty = 0;
        penalty += calculateShotsPenalty(firstShooting);
        penalty += calculateShotsPenalty(secondShooting);
        penalty += calculateShotsPenalty(thirdShooting);
        return penalty;
    }

    private int calculateShotsPenalty(List<ShootingResult> shootingResults) {
        int penaltyTotal = 0;
        for (ShootingResult shootingResult : shootingResults) {
            if (shootingResult == ShootingResult.MISS) {
                penaltyTotal += 10;
            }
        }
        return penaltyTotal;
    }

    public String calculateTotalTime() {
        int penalty = calculatePenaltyTime();
        String[] splitTime = skiTimeResult.split(":");
        int minutes = Integer.parseInt(splitTime[0]);
        int seconds = Integer.parseInt(splitTime[1]);

        seconds += penalty;

        minutes += seconds / 60;
        seconds %= 60;

        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public int compareTo(BiathlonAthlete otherAthlete) {
        int thisTotalSeconds = convertTimeToSeconds(this.calculateTotalTime());
        int otherTotalSeconds = convertTimeToSeconds(otherAthlete.calculateTotalTime());

        return Integer.compare(thisTotalSeconds, otherTotalSeconds);
    }

    public int convertTimeToSeconds(String time) {
        String[] splitTime = time.split(":");
        int minutes = Integer.parseInt(splitTime[0]);
        int seconds = Integer.parseInt(splitTime[1]);
        return minutes * 60 + seconds;
    }

    public void setFirstShooting(String firstShooting) {
        for (int i = 0; i < firstShooting.length(); i++) {
            if (firstShooting.charAt(i) == 'x'){
                this.firstShooting.add(ShootingResult.HIT);
            } else if (firstShooting.charAt(i) == 'o'){
                this.firstShooting.add(ShootingResult.MISS);
            }
        }
    }

    public void setSecondShooting(String secondShooting) {
        for (int i = 0; i < secondShooting.length(); i++) {
            if (secondShooting.charAt(i) == 'x'){
                this.secondShooting.add(ShootingResult.HIT);
            } else if (secondShooting.charAt(i) == 'o'){
                this.secondShooting.add(ShootingResult.MISS);
            }
        }
    }

    public void setThirdShooting(String thirdShooting) {
        for (int i = 0; i < thirdShooting.length(); i++) {
            if (thirdShooting.charAt(i) == 'x'){
                this.thirdShooting.add(ShootingResult.HIT);
            } else if (thirdShooting.charAt(i) == 'o'){
                this.thirdShooting.add(ShootingResult.MISS);
            }
        }
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }
}

