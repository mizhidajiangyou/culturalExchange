export function validateAccountNumber(str) {
  const reg = /^([1-9]{1})(\d{14}|\d{18})$/;
  return reg.test(str);
}

/*export default class Validate {
  validateAccountNumber(str) {
    const reg = /^([1-9]{1})(\d{14}|\d{18})$/;
    return reg.test(str);
  };

}*/


export function test() {
  alert("test"+"以及");
}
