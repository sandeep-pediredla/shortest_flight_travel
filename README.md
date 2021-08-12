# Shortest Flight Travel
You run an airline that has planes that fly to different destinations around the world. Given a
task to fly between two airports you must ensure that each airplane takes the shortest time
to reach its destination.

#### Given that the following routes are available:
| Departure airport iata codes   |      Arrival Airport iata codes      |  Duration in Hours |
|----------|:-------------:|------:|
| DUB  | LHR  | 1 |
| DUB  | CDG  | 2 |
| CDG  | BOS  | 6 |
| CDG  | BKK  | 9 |
| ORD  | LAS  | 2 |
| LHR  | NYC  | 5 |
| NYC  | LAS  | 3 |
| BOS  | LAX  | 4 |
| LHR  | BKK  | 9 |
| BKK  | SYD  | 11 |
| LAX  | LAS  | 2 |
| DUB  | ORD  | 6 |
| LAX  | SYD  | 13 |
| LAS  | SYD  | 14 |
a) Write a program where two airports can be entered at the command line, eg. DUB -
SYD
b) The program returns the shortest route (duration) between the two airports in the
following format:
DUB -- LHR ( 1 )
LHR -- BKK ( 9 )
BKK -- SYD ( 11 )
time: 21
When you are submitting your program please provide a brief description of the approach in
a README.md file as part of a buildable project with source code, appropriate tests and a
URL for where to find the repository

There are multiple ways to solve searching the shortest distance & each have it pros & cons:
1. BFS
2. Floyd-Warshall algorithm
3. Dijkstra's Algorithm

I have used the second approach works well small datasets but consume more space.

## Approach:
1. Fist model csv to pojo
2. Create a graph with connecting airports
3. Provide operation to search shortest path

## Assumptions:
I have taken my own flight dataset as it have more entries.
One of the main advantage of current implemented approach is shortest path were calculated once and we can use for it mutliple searches. So, if we add any new airport, we need to recommute the paths again.

#### Building for source

```sh
mvn clean install
```
## Usage

```java
java FlightTravel.java -f flights.csv -s LGW -e HND
```

### Future features we can incorporate:
1. Shortest path is only consider on journey time instead of whole time (including waiting + connecting).
2. Shortest path calculation implementation should be decouple to use different algorithm based on requirement.
3. Provide option to calculate Shortest path based on user selection criteria.

## License

Public

**Free Software, Hell Yeah!**