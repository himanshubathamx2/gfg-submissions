class Meeting{
    int start;
    int end;
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int activitySelection(int start[], int end[]) {
        int n = start.length;
        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i<n; i++){
            Meeting meeting = new Meeting(start[i], end[i]);
            meetings[i] = meeting;
        }        
        Arrays.sort(meetings,(m1, m2) -> m1.end - m2.end);
        int c = 0;
        int prevEnd = -1;
        for(Meeting meeting : meetings){
            if(meeting.start > prevEnd){
                c++;
                prevEnd = meeting.end;
            }
        }
        return c;
    }
}
