# Launch Interceptor Program

This program simulates the decision making of an anti-ballistic missile system, where the final verdict (launch/do not launch) is based on a series of computations.

## Program Simulation Workflow

The workflow of the program is simulated as follows:

1. The program is provided with inputs:
    1. up to 100 planar data points, representing radar echoes
    2. a $15 \times 15$ symmetric _Logical Connector Matrix_ (LCM), whose elements are `ANDD`, `ORR`, or `NOTUSED`
    3. a 15 elements long boolean _Preliminary Unlocking Vector_ (PUV), which filters out irrelevant LICs
2. 15 Launch Interceptor Conditions (LICs) are evaluated based on the data points and input parameters, and are saved in a Conditions Met Vector (CMV).
3. The LCM rules are applied to the CMV, and the results are saved in a $15 \times 15$ symmetric boolean _Preliminary Unlocking Matrix_ (PUM).
4. The PUM is filtered using the PUV, and the results are saved in a 15-boolean _Final Unlocking Vector_ (FUV).
5. If all the booleans in the FUV are true, the program prints "YES" to the standard output; meaning that the system should launch its defense missiles. Otherwise, it prints "NO".

## How to Use

**TODO:** `main()` is currently empty.

- The program is tested on and works on Java 21.
- Gradle is used for package management and building/running.

To build:
```
./gradlew build
```

To run (also builds unless built manually):
```
./gradlew run
```

## Tests

Tests are run with JUnit 5 (as defined in [libs.versions.toml](gradle/libs.versions.toml)).

To test:
```
./gradlew test
```

Tests are named according to the template `lic{i}_stateUnderTest_expectedOutcome()`. For example, `lic3_negativeAreaInput_returnsFalse()`.


## Contributions
- Jonathan Skantz: Implemented LICs 0, 6, 13, extended the Point class.
- Elias Hollstrand: Implemented LICs 3, 4, 13, created the repo template.
- Elias Gaghlasian: Implemented LICs 5, 7, 11.
- Fabian Holm: Implemented LICs 1, 2, 8.
- Vadim Johan Tristan El Guedj: Implemented LICs 9, 10, 12.

Something that can be considered a valuable and remarkable achievement is that we added a ruleset for protecting the main branch. This ruleset restrict deletions and prevents force pushes. It also requires two approvals before pull requests are merged into main, which allows more team members to practice reading PRs and giving feedback. It is also easy to hastily go through another team member's PR and blindly approve it because we trust each other, but this mistake is minimized by increasing the number of required approvals.

Additionally, we used GitHub Issues for tracking features, bugs, and improvements. Most commits reference issue IDs, and those are in the format "{What this commit will change}. Fix #{issue num}".
