const { chalk, inquirer, print } = require("./tools/index.js");
var moment = require("moment");
var colors = require("colors");
var userHome = require("user-home");

//DETECT IP *START!
var os = require("os");
var interfaces = os.networkInterfaces();
var addresses = [];
for (var k in interfaces) {
  for (var k2 in interfaces[k]) {
    var address = interfaces[k][k2];
    if (address.family === "IPv4" && !address.internal) {
      addresses.push(address.address);
    }
  }
}
//DETECT IP *END!
const questionTools = [
  "➥ Information",
  "➥ increase followeres",
  "➥ increase followeres",
  "\n",
];

const menuQuestion = {
  type: "list",
  name: "choice",
  message:
    "Select tools:\n  Read the (❆ Information) first \n\n",
  choices: questionTools,
};

const main = async () => {
  try {
    const { choice } = await inquirer.prompt(menuQuestion);
    choice == questionTools[0] && require("./tools/info.js");
    choice == questionTools[1] && require("./tools/follow.js");
    choice == questionTools[2] && require("./tools/unfollow.js");
    choice == questionTools[3] && process.exit();
  } catch (err) {
    print(err, "err");
  }
};

console.log(chalk`{bold.red
  ▄──▄█████████████████████████▄──
  ▄█▀░█░█░█░░░░░░░░░░░░░░░░░░░▀█▄
  █░░░█░█░█░░░░░░░░░░░░░░█████░░█
  █░░░█░█░█░░░░░░░░░░░░░░█████░░█
  █░░░█░█░█░░░░░░░░░░░░░░█████░░█
  █░░░░░░░░░▄▄▄█████▄▄▄░░░░░░░░░█
  ███████████▀▀░░░░░▀▀███████████
  █░░░░░░░██░░▄█████▄░░██░░░░░░░█
  █░░░░░░░██░██▀░░░▀██░██░░░░░░░█
  █░░░░░░░██░██░░░░░██░██░░░░░░░█
  █░░░░░░░██░██▄░░░▄██░██░░░░░░░█
  █░░░░░░░██▄░▀█████▀░▄██░░░░░░░█
  █░░░░░░░░▀██▄▄░░░▄▄██▀░░░░░░░░█
  █░░░░░░░░░░▀▀█████▀▀░░░░░░░░░░█
  █░░░░instagram-automation░░░░░░█
  █░░░░ By @shubham_g0sain░░░░░░█
  █░░░░BLACK-KILLER░░░░░░░░░░░░░█
  ▀█▄░░░░░░░░░░░░░░░░░░░░░░░░░▄█▀
  ──▀█████████████████████████▀─
  }`);
console.log(chalk`{bold.red   •••••••••••••••••••••••••••••••••••••••••}`);
console.log(
  "  Ξ START  : ".bold.red + moment().format("D MMMM YYYY, h:mm:ss a")
);
main();
