# Launch Interceptor Program

This program simulates the decision making of an anti-ballistic missile system, where the final verdict (launch/do not launch) is based on a series of computations.

## Program Simulation Workflow

The workflow of the program is simulated as follows:

1. The program is provided with inputs:
    1. up to 100 planar data points, representing radar echoes
    2. a $15 \times 15$ symmetric _Logical Connector Matrix_ (LCM), containing `ANDD`, `ORR`, or `NOTUSED`
    3. a 15-element boolean _Preliminary Unlocking Vector_ (PUV), which filters irrelevant LICs
2. 15 Launch Interceptor Conditions (LICs) are evaluated based on the data points and input parameters, and are stored in a Conditions Met Vector (CMV).
3. The LCM rules are applied to the CMV to produce a $15 \times 15$ symmetric boolean _Preliminary Unlocking Matrix_ (PUM).
4. The PUV filters the PUM to produce a 15-element boolean _Final Unlocking Vector_ (FUV).
5. If all values in the FUV are true, the program prints "YES" to the standard output; meaning that the system should launch its defense missiles. Otherwise, it prints "NO".

## Requirements

- Java Development Kit (JDK): Java 21
- Gradle: 9.3.0, provided via the Gradle Wrapper (`./gradlew`)
    - **NOTE:** No system Gradle installation is required
- Test framework: JUnit 5, configured in [gradle/libs.versions.toml](gradle/libs.versions.toml)
    - **NOTE:** Installed and managed automatically by Gradle

## How to Use

### Building
To build the project:
```
./gradlew build
```

### Running
To run the program (builds automatically if needed):
```
./gradlew run
```

### Tests

Tests are implemented using JUnit 5.

To run all tests:
```
./gradlew test
```

#### Test Organization

Test methods follow the naming convention:
```
lic{i}_stateUnderTest_expectedOutcome()
```

Example:
```
lic3_negativeAreaInput_returnsFalse()
```


## Contributions
- **Jonathan Skantz:** Implemented LICs 0, 6, 13; extended the Point class
- **Elias Hollstrand:** Implemented LICs 3, 4, 13; created the repo template
- **Elias Gaghlasian:** Implemented LICs 5, 7, 11
- **Fabian Holm:** Implemented LICs 1, 2, 8
- **Vadim El Guedj:** Implemented LICs 9, 10, 12

Something that can be considered a valuable and remarkable achievement is that we added a ruleset for protecting the main branch. This ruleset restrict deletions and prevents force pushes. It also requires two approvals before pull requests are merged into main, which allows more team members to practice reading PRs and giving feedback. It is also easy to hastily go through another team member's PR and blindly approve it because we trust each other, but this mistake is minimized by increasing the number of required approvals.

Additionally, we used GitHub Issues for tracking features, bugs, and improvements. Most commits reference issue IDs, and those are in the format "{What this commit will change}. Fix #{issue num}".
