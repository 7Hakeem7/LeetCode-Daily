class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // For energy, take value > the total sum; then total sum - initialEnergy
        // For experience, calculate the minimum training needed to handle all opponents in order
        int neededEnergy = 0;
        int energyTrainingTime = 0;
        int sum = 0;

        // Calculate the total energy needed to defeat all opponents
        for (int i = 0; i < energy.length; i++) {
            sum += energy[i];
        }
        // Ensure you have at least one extra energy left after all battles
        if (initialEnergy <= sum) {
            neededEnergy = sum + 1;
            energyTrainingTime = neededEnergy - initialEnergy;
        }

        // For finding neededExperience
        int neededExp = 0;
        int expTrainingTime = 0;

        // Iterate through the experience array to calculate training required
        for (int i = 0; i < experience.length; i++) {
            // If the current experience is less than or equal to the opponent's experience
            if (initialExperience <= experience[i]) {
                neededExp += (experience[i] - initialExperience + 1);
                initialExperience = experience[i] + 1; // Train to exceed opponent's experience
            }
            // Gain experience after defeating the opponent
            initialExperience += experience[i];
        }

        expTrainingTime = neededExp;

        // Return the total training time required
        return energyTrainingTime + expTrainingTime;
    }
}
