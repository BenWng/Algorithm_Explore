/**
 * Created by Ben_Big on 10/19/16.
 */

/*
 332. Reconstruct Itinerary   QuestionEditorial Solution  My Submissions
 Total Accepted: 21341
 Total Submissions: 78698
 Difficulty: Medium
 Contributors: Admin
 Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */

//ToDo: need revisit

var dict={};

function addToDict(input){
    for(var num in input){
        var itinerary=input[num];
        if (itinerary[0] in dict){
            dict[itinerary[0]].push(itinerary[1]);
        }
        else{
            dict[itinerary[0]]=[];
            dict[itinerary[0]].push(itinerary[1]);
        }
    }
    for (start  in dict){
       dict[start].sort(function(a,b){
           return a<b?1:a===b?0:-1;
       });
    }

}



function reconstruct(){
    var tickets=[];
    var start="JFK";
    function recursiveCall(beginPoint){
        while(dict[beginPoint]!==undefined && dict[beginPoint].length!==0){
            var nextNode=dict[beginPoint].pop();
            recursiveCall(nextNode);
        }
        tickets.unshift(beginPoint);
    }
    recursiveCall(start);
    return tickets;
}


function reconstructItinerary(input){
    addToDict(input);
    return reconstruct();
}

console.log(reconstructItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]));
console.log(reconstructItinerary([["JFK","ATL"],["ORD","PHL"],["JFK","ORD"],["PHX","LAX"],["LAX","JFK"],["PHL","ATL"],["ATL","PHX"]]));
console.log(reconstructItinerary([["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]));