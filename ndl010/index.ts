import * as readline from 'readline';

function sortVowelsConsonants(text: string): void {
  text = text.toLowerCase();

  const vowels = "aiueo";
  const vowelIndices: Record<string, number> = {};
  const vowelList: string[][] = [];
  const consonantIndices: Record<string, number> = {};
  const consonantList: string[][] = [];

  for (let i = 0; i < text.length; i++) {
    const char = text[i];
    let isVowel = false;

    if (vowels.includes(char)) {
      isVowel = true;
      if (!(char in vowelIndices)) {
        vowelIndices[char] = vowelList.length;
        vowelList.push([]);
      }
      vowelList[vowelIndices[char]].push(char);
    } else if (char >= "a" && char <= "z") {
      if (!(char in consonantIndices)) {
        consonantIndices[char] = consonantList.length;
        consonantList.push([]);
      }
      consonantList[consonantIndices[char]].push(char);
    }
  }

  console.log("Vowel Characters :\n" + vowelList.flat().join(''));
  console.log("Consonant Characters :\n" + consonantList.flat().join(''));
}

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("Input one line of words (S): ", (input) => {
  sortVowelsConsonants(input);
  rl.close();
});
