
#   Energy-Consumption-of-Web-Frontend-Frameworks-An-Empirical-Comparison-of-Angular-and-React


An empirical study comparing the energy consumption of equivalent applications implemented in Angular and React under controlled execution scenarios, using the Firefox Power Profiler and automated execution scenarios.

## Repository Structure
```
├── petstore-backend-spring-mysql/ # Spring Boot REST API (MySQL)
│
├── petstore-angular-frontend/ # Angular frontend application
│
├── petstore-react-frontend/ # React + Vite frontend application
│
├── frontend-benchmarking/ # Energy benchmarking & automation
│
└── README.md # Project documentation
```
## Prerequisites

### Test Environment

- **Hardware**: MacBook Pro with Apple Silicon M2 Pro  
  (per-process “tab” energy consumption measurement), 16 GB RAM
- **Browser**: Firefox (latest stable version)
- **Measurement Tool**: Firefox Profiler extension  
  - [Profiler Web Interface](https://profiler.firefox.com/)
  - [Profiler Source Code](https://github.com/mozilla/gecko-dev/tree/master/devtools/client/performance-new)
- **Automation**: PyAutoGUI (Python library)

### Software Requirements

- **Node.js**
  - Angular frontend: `^18.19.1 || ^20.11.1 || ^22`
  - React frontend: `>= 20`
- **Python**: 3.x

### Backend Requirements

- **JDK**: 21
- **Maven**
- **MySQL**
## Getting Started

To try this project, simply **clone the repository locally** and navigate to the different folders.  
Each major component contains its own dedicated `README.md` with detailed setup and usage instructions.

```
git clone https://github.com/anasshatnawi/Energy-Consumption-of-Web-Frontend-Frameworks-An-Empirical-Comparison-of-Angular-and-React.git 

```` 
- First install the two versions of the frontend application 
    - For Angular find the installation details [here](./petstore-angular-frontend/README.md)
    - For React find the installation details [here](./petstore-react-frontend/README.md)
- To be able to use the full application install the backend API following the [details](./petstore-backend-spring-mysql/README.md)
- The benchmarking of the frontend versions is automated using multiple scripts with an installation detailled [here](./frontend-benchmarking/README.md)
