from rembg import remove
from PIL import Image
import sys
import io
import os

QUALITY = 25  # 25% quality

# Gradient colors (RGB)
COLOR_START = (42, 123, 155)   # #2A7B9B
COLOR_MID   = (87, 199, 133)   # #57C785
COLOR_END   = (237, 221, 83)   # #EDDD53

def create_horizontal_gradient(width, height):
    gradient = Image.new("RGB", (width, height))
    for x in range(width):
        ratio = x / width

        if ratio < 0.5:
            # Start -> Mid
            t = ratio / 0.5
            r = int(COLOR_START[0] + (COLOR_MID[0] - COLOR_START[0]) * t)
            g = int(COLOR_START[1] + (COLOR_MID[1] - COLOR_START[1]) * t)
            b = int(COLOR_START[2] + (COLOR_MID[2] - COLOR_START[2]) * t)
        else:
            # Mid -> End
            t = (ratio - 0.5) / 0.5
            r = int(COLOR_MID[0] + (COLOR_END[0] - COLOR_MID[0]) * t)
            g = int(COLOR_MID[1] + (COLOR_END[1] - COLOR_MID[1]) * t)
            b = int(COLOR_MID[2] + (COLOR_END[2] - COLOR_MID[2]) * t)

        for y in range(height):
            gradient.putpixel((x, y), (r, g, b))

    return gradient

def remove_background(input_path, output_path):
    if not os.path.exists(input_path):
        print(f"Input file not found: {input_path}")
        sys.exit(1)

    # Read image
    with open(input_path, "rb") as inp:
        input_bytes = inp.read()

    # Remove background
    output_bytes = remove(input_bytes)
    img = Image.open(io.BytesIO(output_bytes)).convert("RGBA")

    width, height = img.size

    # Create gradient background
    gradient_bg = create_horizontal_gradient(width, height)

    # Paste subject on gradient
    gradient_bg.paste(img, mask=img)

    # Save compressed JPG
    gradient_bg.save(output_path, "JPEG", quality=QUALITY, optimize=True)

    print("Gradient background applied and image compressed")

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python process_image.py <input_image> <output_image>")
        sys.exit(1)

    remove_background(sys.argv[1], sys.argv[2])
