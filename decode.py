# This is your decode function from the screenshot you provided
def decode(message_file):
    with open(message_file, 'r') as file:
        lines = file.readlines()

    pairs = [line.split() for line in lines]
    pairs = [(int(number), word.strip()) for number, word in pairs]

    pairs.sort()

    step = 1
    index = 0
    message_words = []

    while index < len(pairs):
        message_words.append(pairs[index + step - 1][1])
        index += step
        step += 1

    return ' '.join(message_words)

# Test the function
def test_decode():
    decoded_message = decode('coding_qual_input.txt')
    print(f"Decoded Message: '{decoded_message}'")

# Run the test
test_decode()
