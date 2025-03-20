// 1. 가져오기
// import { name, age, greet } from "./modules/01_named_export.js";

// console.log(name);
// console.log(age);
// console.log(greet());

/**2. 별칭으로 가져오기 */
// import {
//   name as userName,
//   age as userAge,
//   greet,
// } from "./modules/01_named_export.js";

// console.log(userName);
// console.log(userAge);

// 3. 전부 가져오기
// import * as utils from "./modules/01_named_export.js";

// console.log(utils.age);
// console.log(utils.name);
// console.log(utils.greet());

// 4. default export

// import addFunction from "./modules/02_default_export.js";

// console.log(addFunction(4, 5));

import { name, age, greet } from "./modules/03_export.js";

console.log(name);
