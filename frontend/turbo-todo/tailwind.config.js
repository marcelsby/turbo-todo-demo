module.exports = {
  content: ["./src/**/*.{html,js,tsx}"],
  theme: {
    extend: {
      colors: {
        brandGreen: {
          400: "#B5E593",
          500: "#9CE07B",
          600: "#8FCE71",
        },
        brandCream: {
          400: "#FFF6DD",
          500: "#FFECB8",
        },
        brandBlue: "#9CCFFD",
        brandRed: "#FF6868",
      },
    },
    borderRadius: {
      lg: "10px",
    },
  },
  plugins: [],
};
