# example_1

Calculating the minimum price plans for given features.

## Requirements

openjdk 11.0.15 \
Gradle 6.8.3

## Commands

### To build
`gradle clean build`

### To execute

`gradle run --args="<file_path> <features>"`

Ex:\
`gradle run --args="/home/didula/workspace_dlak/telepathy/example_2/Example1.txt email,voice,admin"`

Use this command to review the failed test case.\
`gradle run --args="/home/didula/workspace_dlak/telepathy/example_2/Example2.txt F4,F7,F9,F6,F5,F8,F1,F3,F0"`
