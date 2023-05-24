# Finance-Manager
Planning your budget can be a hard thing as not everybody has the financial management skills. It can be hard for some to keep in mind all their financial plans, so it is essential to find a way to cope with it - use a paper planner, or download this application. This console app is designed to help the user plan their budget. You can add planned expenses and incomes, save them in the app, see your current balance, view other useful information on your budget.


Currently, the user interface is console and the storage mechanism is file serialization. It can be easily changed to GUI or DB by implementing UserInterface and StorageProcessor interfaces.


Functionality breakdown:

- if you're first to the program, you will be asked to enter your name and current budget

- add expense/income: add your planned transaction (comment + amount) so it is stored in the program

- change budget: add immediate changes to your budget

- compare all: see financial stats based off your budget + planned expenses + planned incomes

- compare plans: see stats based off your planned expenses + incomes

- mark expense/income done: delete it from the planned list and change your budget accorsing to it being done

- remove expense/income: delete it without budget changes

- show history stats: see stats according to your previously marked as done expenses/incomes 

- view budget/expenses/incomes: see this info in a readable way

Linter used: SonarLint.


Tests: JUnit.


License: GNU General Public License.
