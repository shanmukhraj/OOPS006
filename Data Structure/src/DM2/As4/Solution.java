package DM2.As4;
class Solution{
	public Team[] sort(Team[] teams){
		 for (int index = 0; index < teams.length; index++){
	            Team temp = teams[index], m = teams[index];
	            int max_index = index;
	            for(int next_index = index + 1; next_index < teams.length; next_index++){
	                if (m.noOfWins < teams[next_index].noOfWins) {
	                	m = teams[next_index];
	                	max_index = next_index;
	                }
	                else if(m.noOfWins == teams[next_index].noOfWins) {
	                	if (m.noOfLosses > teams[next_index].noOfLosses) {
	                		m = teams[next_index];
		                	max_index = next_index;
	                	}
	                	else if(m.noOfLosses == teams[next_index].noOfLosses) {
	                		if (m.noOfDraws < teams[next_index].noOfDraws) {
		                		m = teams[next_index];
			                	max_index = next_index;
		                	}
	                	}
	                }
	            }   
	                teams[index] = teams[max_index];
	                teams[max_index] = temp;
	        }
	       
		 return teams;
	}
		
	}

class Team {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return teamName+", "+noOfWins+", "+noOfLosses+", "+noOfDraws;
    }
	}


